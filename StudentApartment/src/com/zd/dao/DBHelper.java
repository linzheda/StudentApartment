package com.zd.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



import com.zd.util.LogUtil;



public class DBHelper {
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	static{
		try {
			/*Context context = new  InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/product");*/
			Class.forName(  MyProperties.getInstance().getProperty("driverClassName" ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection( MyProperties.getInstance().getProperty("url" ),MyProperties.getInstance().getProperty("username" ),MyProperties.getInstance().getProperty("password" ));
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (dataSource != null){
//			try {
//				con = dataSource.getConnection();   
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} 
//		}
		return con;
	}
	/**
	 * 关闭的方法
	 */
	public void closeAll(Connection con,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				LogUtil.log.error(e.toString());
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				LogUtil.log.error(e.toString());
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				LogUtil.log.error(e.toString());
			}
		}
	}

	/**
	 * 设置PreparedStatement对象的sql语句中的参数？
	 */
	public void setValues(PreparedStatement pstmt,List<Object> params){
		if(pstmt!=null&&params!=null&&params.size()>0){
			String type=null;
			for(int i=0;i<params.size();i++){
				Object o=params.get(i);
				try {
					if(o!=null){
						type=o.getClass().getName();
						if("javax.sql.rowset.serial.SerialBlob".equals(type)){
							pstmt.setBlob(i+1, (Blob)params.get(i));
						}else if("java.lang.Integer".equals(type)){
							pstmt.setInt(i+1,Integer.parseInt(String.valueOf(o)));
						}else{
							pstmt.setString(i+1,String.valueOf(o));
						}
					}else{
						pstmt.setString(i+1,"");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					LogUtil.log.error(e.toString());
				}
			}
		}
	}
	
	public void setValues(PreparedStatement pstmt,Object ... objs){
		if(pstmt!=null&&objs!=null&&objs.length>0){
			String type=null;
			for(int i=0,len=objs.length;i<len;i++){
				Object o=objs[i];
				try {
					if(o!=null){
						type=o.getClass().getName();
						if("javax.sql.rowset.serial.SerialBlob".equals(type)){
							pstmt.setBlob(i+1, (Blob)o);
						}else if("java.lang.Integer".equals(type)){
							pstmt.setInt(i+1,Integer.parseInt(String.valueOf(o)));
						}else{
							pstmt.setString(i+1,String.valueOf(o));
						}
					}else{
						pstmt.setString(i+1,"");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					LogUtil.log.error(e.toString());
				}
			}
		}
	}

	/**
	 * 增删改
	 * @param sql：sql语句集合，里面可以加？
	 * @param params：表示?对应的参数值的集合
	 * @return int:返回的值。成功>0，失败<=0
	 */
	public int update(List<String> sql,List<List<Object>> params){
		int result=0;
		con=getConnection();	
		try {
			con.setAutoCommit(false);  //事务处理
			for(int i=0;i<sql.size();i++){
				List<Object> param=params.get(i);
				pstmt=con.prepareStatement(sql.get(i));  //预编译对象
				setValues(pstmt,param);    //设置参数
				result=pstmt.executeUpdate();
			}
			con.commit(); //没有错处执行
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.log.error(e.toString());
			try {
				con.rollback();  //出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			closeAll(con,pstmt,null);
		}
		return result;
	}
	
	/**
	 * 单表增删改
	 * @param sql：sql语句集合，里面可以加？
	 * @param params：表示?对应的参数值的集合
	 * @return int:返回的值。成功>0，失败<=0
	 */
	public int update(String sql,List<Object> params){
		int result=0;
		con=getConnection();
		try {
			pstmt=con.prepareStatement(sql);  //预编译对象
			setValues(pstmt,params);    //设置参数
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			LogUtil.log.error(e.toString());
			try {
				con.rollback();  //出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			closeAll(con,pstmt,null);
		}
		return result;
	}
	
	public int update(String sql,Object ... params){
		int result=0;
		con=getConnection();
		try {
			pstmt=con.prepareStatement(sql);  //预编译对象
			setValues(pstmt,params);    //设置参数
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			LogUtil.log.error(e.toString());
			try {
				con.rollback();  //出错回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			closeAll(con,pstmt,null);
		}
		return result;
	}

	
	
	/**
	 * 聚合查询
	 * @param sql：聚合查询语句
	 * @param params：参数列表，用来替换sql中的?（占位符）
	 * @return list:结果集
	 */

	public List<String> find(String sql,List<Object> params){
		List<String> list=new ArrayList<String>();
		con=getConnection();
		try {
			pstmt=con.prepareStatement(sql);  //预编译对象
			setValues(pstmt,params);   //设置参数
			rs=pstmt.executeQuery();  //执行查询

			ResultSetMetaData md=rs.getMetaData();  //结果集的元数据，它反映了结果集的信息
			int count=md.getColumnCount();    //取出结果集中列的数量

			if(rs.next()){
				for(int i=1;i<=count;i++){
					list.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			LogUtil.log.error(e.toString());
		}finally{
			closeAll(con,pstmt,rs);
		}
		return list;
	}
	
	public List<String> find(String sql,Object ... params){
		List<String> list=new ArrayList<String>();
		con=getConnection();
		try {
			pstmt=con.prepareStatement(sql);  //预编译对象
			setValues(pstmt,params);   //设置参数
			rs=pstmt.executeQuery();  //执行查询

			ResultSetMetaData md=rs.getMetaData();  //结果集的元数据，它反映了结果集的信息
			int count=md.getColumnCount();    //取出结果集中列的数量

			if(rs.next()){
				for(int i=1;i<=count;i++){
					list.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.log.error(e.toString());
		}finally{
			closeAll(con,pstmt,rs);
		}
		return list;
	}

	/**
	 * 查询单个表
	 * @param <T> 泛型：即你要得到的集合中存的对象的类型
	 * @param sql: 查询语句，可以含有?
	 * @param params: ?所对应的参数值的集合
	 * @param c： 泛型类型所对应的反射对象
	 * @return ：存储了对象的集合
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws NumberFormatException 
	 */
	public <T> List<T> find(String sql,Class<T> c,List<Object> params) throws InstantiationException, IllegalAccessException, NumberFormatException, IllegalArgumentException, InvocationTargetException {
		if( params == null ){
			return find(sql,c);
		}else{
			return find(sql ,c , params.toArray());
		}
	}
	
	private Set<String> getMethodName( Set<String> keys ){
		Set<String> result = new HashSet<String>();
		for( String key:keys ){
			String newName = key.substring(0,1).toUpperCase()+key.substring(1);
			result.add("set" + newName );
		}
		return result ;
	}
	
	public <T> List<T> find(String sql,Class<T> c,Object ... params) throws InstantiationException, IllegalAccessException, NumberFormatException, IllegalArgumentException, InvocationTargetException {
		List<Map<String,Object>> listMap = finds( sql , params );
		List<T> list=new ArrayList<T>(); //要返回的结果的集合
		
		T t = null ;
		
		if( listMap == null || listMap.size() <= 0 ){
			return list;
		}
		
		//取出键
		Map<String,Object> map = listMap.get(0);	//取出的是一个map的键值对的形式
		Set<String> keys = map.keySet();     //这里取出的是map键值对中的键名
		
		//将键名拼接上set ，变成要找的方法名
		Set<String> methodNames = getMethodName(keys);  //set键名
		Method[] ms = c.getMethods();
		for( Map<String,Object> m:listMap ){
			t = (T) c.newInstance(); //创建反射类的实例化对象Product 
			//循环所有的方法，查到 与methodNames 中的相同的方法
			for ( Method method: ms ){
				for( String mn : methodNames ){	  //setResadmin 
					if( method.getName().equals(mn)){
						//激活这个method   用invoke 
						String keyname = mn.substring(3,4).toLowerCase()+mn.substring(4);
						
						String typeName = method.getParameterTypes()[0].getName();
						if( "java.lang.Integer".equals(typeName)  ||  "int".equals(typeName) ){
							method.invoke(t , Integer.parseInt(m.get(keyname).toString() ));
						}else if( "java.lang.Double".equals(typeName)  ||  "double".equals(typeName) ){
							method.invoke(t , Double.parseDouble(m.get(keyname).toString() ));
						}else if( "java.lang.Float".equals(typeName)  ||  "float".equals(typeName) ){
							method.invoke(t , Float.parseFloat(m.get(keyname).toString() ));
						}else if( "java.lang.Long".equals(typeName)  ||  "long".equals(typeName) ){
							method.invoke(t , Long.parseLong(m.get(keyname).toString() ));
						}else {
							method.invoke(t , m.get(keyname).toString() );
						}
						break;
					}
				}
			}
			list.add(t);
		}
		
		return list;
	}
	
	/**
	 * 查询操作
	 * @param sql：要执行的查询语句
	 * @param params：查询语句中，对用占位符?的值
	 * @return：返回满足条件的所有数据
	 */
	public List<Map<String,Object>> finds(String sql,List<Object> params){
		if( params == null ){
			return finds(sql);
		}else{
			return finds(sql, params.toArray());
		}
	}
	
	/**
	 * 查询操作
	 * @param sql：要执行的查询语句
	 * @param params：查询语句中，对用占位符?的值
	 * @return：返回满足条件的所有数据
	 */
	public List<Map<String,Object>> finds(String sql,Object ... objs){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

		try {
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);

			this.setValues(pstmt,objs);//给占位符赋值

			rs=pstmt.executeQuery();//获取结果集

			//获取返回结果中的列的列名
			ResultSetMetaData rsmd=rs.getMetaData();
			int colLen=rsmd.getColumnCount(); //获取结果集中列的数量
			String[] colNames=new String[colLen];

			for(int i=0;i<colLen;i++){//取出每个列的列名存放到数组中
				colNames[i]=rsmd.getColumnName(i+1);
			}

			Map<String,Object> map=null;
			String typeName;
			Object obj;
			while(rs.next()){//循环取值，每循环一次就是一条记录，存放到一个map中
				map=new HashMap<String,Object>();
				for(int i=0;i<colLen;i++){ //循环取出每个列的值
					obj=rs.getObject(colNames[i]);
					if(obj!=null){
						typeName=obj.getClass().getSimpleName();
						if("BLOB".equals(typeName)){
							Blob blob=rs.getBlob(colNames[i]);
							byte[] bt=null;
							BufferedInputStream bis=null;
							try {
								bis=new BufferedInputStream( blob.getBinaryStream());
								bt=new byte[(int) blob.length()];
								bis.read(bt);
								map.put(colNames[i],bt);
							} catch (IOException e) {
								e.printStackTrace();
							}  finally{
								if(bis!=null){
									try {
										bis.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}else{
							map.put(colNames[i],rs.getString(colNames[i])); 
						}
					}else{
						map.put(colNames[i],""); //以当前列的列名为键，以当前列的值为值
					}
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.log.error(e.toString());
		} finally{
			this.closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	

}
