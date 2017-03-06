package com.mb.middle.ware.controller.api;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mb.middle.ware.base.BaseController;
import com.mb.middle.ware.utils.Constant;
import com.mb.middle.ware.utils.Constant.Status;
import com.mb.middle.ware.utils.ShareTool;
import com.mb.middle.ware.vo.ResponseVO;
import com.mb.middle.ware.vo.form.LoginEnterpriseVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@Scope(value = "prototype")
@RequestMapping(value = "/MiddleWareApi")
public class MiddleWareApiController extends BaseController{
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.
				currentRequestAttributes()).getRequest();
		super.init(request);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody ResponseVO login(HttpServletRequest request, @RequestBody @Valid LoginEnterpriseVO requestVO, 
			BindingResult result) throws Exception{
		ResponseVO responseVO = new ResponseVO();

		if(result.hasErrors()){
			responseVO.setStatus(Status.FIELD_MSG001.getCode());
			responseVO.setMessage(Status.FIELD_MSG001.getMessage());
			responseVO.setResult(ShareTool.simpleFieldError(result.getFieldErrors()));
			return responseVO;
		}
		
		responseVO = ShareTool.callApi(Constant.MAIN_LOGIN_API, ShareTool.toJsonStringBuilder(requestVO), 
				RequestMethod.POST.name());

		return responseVO;
	}

	@RequestMapping(value = "/getEnterpriseServices/{guid}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody ResponseVO getEnterpriseServices(HttpServletRequest request, @PathVariable String guid) throws Exception{
		ResponseVO responseVO = new ResponseVO();
		
		responseVO = ShareTool.callApi(Constant.MAIN_GET_ENTERPRISE_SERVICES_API, guid, RequestMethod.GET.name());
		
		return responseVO;
	}
	
	/*
	 * Exception Handler
	 */
	
	@Override
	@ExceptionHandler(Exception.class)
	public ResponseVO handleError(HttpServletRequest req, Exception exception) {
		return super.handleError(req, exception);
	}
}
