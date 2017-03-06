package com.mb.middle.ware.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;

import com.mb.middle.ware.base.BaseController;
import com.mb.middle.ware.utils.Constant;
import com.mb.middle.ware.utils.ShareTool;
import com.mb.middle.ware.vo.ResponseVO;
import com.mb.middle.ware.vo.form.DeleteEmployeeVO;
import com.mb.middle.ware.vo.form.NewEmployeeVO;
import com.mb.middle.ware.vo.form.UpdateEmployeeVO;

import lombok.extern.log4j.Log4j;


@Log4j
@RestController
@Scope(value = "prototype")
@RequestMapping(value = "/MiddleWare")
public class MiddleWareController extends BaseController{
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.
				currentRequestAttributes()).getRequest();
		super.init(request);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{guid}", method = RequestMethod.GET)
	public @ResponseBody Object index(HttpServletRequest request, @PathVariable String guid) throws Exception{
		HashMap<String, Object> employeeMap = new HashMap<String, Object>();
		
		ResponseVO responseVO = ShareTool.callApi(Constant.MAIN_LIST_EMPLOYEE_API, guid, RequestMethod.GET.name());
		
		/*
		 * 傳回來的result有可能是LinkedHashMap或String
		 */
		
		try {
			if(StringUtils.isBlank((String) responseVO.getResult())){
				return new ModelAndView(Constant.SYSTEM_INVALID, "message", responseVO.getMessage());
			}
		} catch (ClassCastException e) {
			
			/*
			 * 只catch型別錯誤，因為目前MAIN回傳的RESULT型態只會有String或LinkedHashMap
			 */
			
			LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) responseVO.getResult();
			employeeMap.put("employeeList", data.get("employeeList"));
			employeeMap.put("enterpriseGuid", data.get("enterpriseGuid"));
		}
		
		return new ModelAndView(Constant.SYSTEM_INDEX, "employeeMap", employeeMap);
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody Object newEmployee(HttpServletRequest request, @RequestBody @Valid NewEmployeeVO requestVO, 
			BindingResult result) throws Exception{
		ResponseVO responseVO = new ResponseVO();
		
		if(result.hasErrors()){
			responseVO.setMessage(ShareTool.simpleFieldError(result.getFieldErrors()));
			return responseVO;
		}
		
		responseVO = ShareTool.callApi(Constant.MAIN_NEW_EMPLOYEE_API, ShareTool.toJsonStringBuilder(requestVO), 
				RequestMethod.POST.name());
		
		return responseVO;
	}

	@RequestMapping(value = "/employeeEditDetail/{guid}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody Object employeeEditDetail(HttpServletRequest request, @PathVariable String guid) throws Exception{
		ResponseVO responseVO = ShareTool.callApi(Constant.MAIN_DETAIL_EMPLOYEE_API, guid, RequestMethod.GET.name());

		return responseVO;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody Object updateEmployee(HttpServletRequest request, @RequestBody @Valid UpdateEmployeeVO requestVO, 
			BindingResult result) throws Exception{
		ResponseVO responseVO = new ResponseVO();
		
		if(result.hasErrors()){
			responseVO.setMessage(ShareTool.simpleFieldError(result.getFieldErrors()));
			return responseVO;
		}
		
		responseVO = ShareTool.callApi(Constant.MAIN_UPDATE_EMPLOYEE_API, ShareTool.toJsonStringBuilder(requestVO), 
				RequestMethod.POST.name());

		return responseVO;
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody Object deleteEmployee(HttpServletRequest request, @RequestBody DeleteEmployeeVO requestVO, 
			BindingResult result) throws Exception{
		ResponseVO responseVO = new ResponseVO();
		
		responseVO = ShareTool.callApi(Constant.MAIN_DELETE_EMPLOYEE_API, ShareTool.toJsonStringBuilder(requestVO), 
				RequestMethod.POST.name());

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
