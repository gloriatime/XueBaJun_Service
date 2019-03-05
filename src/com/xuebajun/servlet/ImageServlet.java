package com.xuebajun.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ����ʵ��С�ļ����ڴ棬���ļ��Ŵ���
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    // С�ļ�����ļ��ķֽ�㣬Ĭ��10kb
	    factory.setSizeThreshold(20*1024);
	    
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    
	    // �ļ����Ϊ5M
	    upload.setSizeMax(5*1024*1024);
	    
	    List itemList;
		try {
			itemList = upload.parseRequest(request);
			
		    Iterator it = itemList.iterator();
		    
		    while(it.hasNext())
		    {
		    	 
		    	 FileItem item =(FileItem) it.next();
		    	
		    	 if(item.isFormField())
		    	 {
		    		String name = (String)item.getFieldName();
		    		
		    	 }
		    	 else
		    	 {
		    		
		    		 String name =item.getName();
		    		
		    	 
		    		 File file = new File(request.getServletContext().getRealPath("/head_image"), name);
		    		 
					 
					 file.getParentFile().mkdirs();
					 
					 // ɾ����ͷ��
					 if(file.exists()) {
						 file.delete();
					 }
					 
					 item.write(file);
		    		 
		    	 }
		    	
		    }
		    
		    
		    
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
