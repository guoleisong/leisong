package cn.agrotechnical.controller;

import cn.agrotechnical.common.PageResult;
import cn.agrotechnical.common.Result;
import cn.agrotechnical.common.StatusCode;
import cn.agrotechnical.pojo.Problem;
import cn.agrotechnical.service.ProblemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	@RequestMapping(value="/newlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
	public Result newList(@PathVariable String labelid, @PathVariable int page, @PathVariable int size){
		Page<Problem> newlitst = problemService.newlitst(labelid, page, size);
		return new Result(true, StatusCode.OK,"查询成功",newlitst);
	}

	@RequestMapping(value="/hotlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
	public Result hotList(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> hotlitst = problemService.hotlitst(labelid, page, size);
		return new Result(true,StatusCode.OK,"查询成功",hotlitst);
	}

	@RequestMapping(value="/waitlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
	public Result waitList(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> waitlitst = problemService.waitlitst(labelid, page, size);
		return new Result(true,StatusCode.OK,"查询成功",waitlitst);
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}


	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
