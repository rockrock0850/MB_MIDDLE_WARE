package com.mb.middle.ware.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.mb.middle.ware.utils.Constant.Status;
import com.mb.middle.ware.vo.ResponseVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BaseController {
	private Logger log = Logger.getLogger(this.getClass());
	
	/*
	 * 
	 */
	
	protected String baseDir;
	protected String baseUri;
	
	/**
	 * 
	 * @param request
	 * @param txManager
	 */
	public void init(HttpServletRequest request){
		String url = request.getRequestURL().toString();
		this.baseUri = url.replace(request.getServletPath(), "");
		this.baseDir = request.getSession().getServletContext().getRealPath("").
				replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\", "");
		System.setProperty("baseDir", baseDir);
	}
	
	/**
	 * 
	 * @param req
	 * @param exception
	 * @return
	 */
	public ResponseVO handleError(HttpServletRequest req, Exception e) {
		/*ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");*/
		 
		ResponseVO responseVO = new ResponseVO();
		responseVO.setStatus(Status.UNKNOWN_ERROR.getCode());
		responseVO.setMessage(Status.UNKNOWN_ERROR.getMessage());
		responseVO.setResult(new StringBuilder("Request: " + req.getRequestURL() + ", Throws ****" + e.getMessage() + "****"));
		
		log.error(e, e);
		
		return responseVO;
	}
}
