package com.jade.swp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jade.swp.domain.Board;
import com.jade.swp.domain.Criteria;
import com.jade.swp.domain.PageMaker;
import com.jade.swp.domain.User;
import com.jade.swp.interceptor.SessionNames;
import com.jade.swp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	private BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(Board board, Model model) throws Exception {
		logger.info("regist GET .....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(Board board, RedirectAttributes rttr) throws Exception {
		logger.info("regist POST ..... {}", board.toString());
		service.regist(board);

//		model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg", "success");
//		return "/board/success";
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(
			@RequestParam("bno") Integer bno,
			@ModelAttribute("criteria") Criteria criteia,
			HttpServletResponse response,
			Model model) throws Exception {
		logger.info("read GET .....");
		Board board = service.read(bno);
		logger.info(">>>> board.read: {}", board);
		if (board == null) {
			response.sendError(404);
		}
		logger.info("::>>>> board.read: {}", board);
		
		model.addAttribute(board);
		return "/board/read";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAttach/{bno}", method = RequestMethod.GET)
	public List<String> read(@PathVariable ("bno") Integer bno) throws Exception {
		logger.info("getAttach ..... bno={}", bno);
		return service.getAttach(bno);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGet(@RequestParam("bno") Integer bno,
			@ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {
		logger.info("update GET .....");
		Board board = service.read(bno);
		logger.info(">>>> board.update: {}", board);
		model.addAttribute(board);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePost(Board board, Criteria criteria, RedirectAttributes rttr) throws Exception {
		logger.info("update POST ..... {}", board);
		service.modify(board);
		rttr.addFlashAttribute("msg", "save-ok");
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addAttribute("searchType", criteria.getSearchType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		return "redirect:/board/read?bno=" + board.getBno();
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") Integer bno, Criteria criteria, RedirectAttributes rttr) throws Exception {
		logger.info("remove GET .....");
		service.remove(bno);
		rttr.addFlashAttribute("msg", "remove-ok");
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addAttribute("searchType", criteria.getSearchType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info(">>>> listAll");
		List<Board> boards = service.listAll();
		model.addAttribute("list", boards);
	}
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(Criteria criteria, Model model, HttpSession session) throws Exception {
		logger.info(">>>> listPage {}", criteria);
		List<Board> boards = service.listCriteria(criteria);
		model.addAttribute("list", boards);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		int totalCount = service.countPaging(criteria);
		logger.debug("totalCount=" + totalCount);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		
		String now = service.getTime();
		model.addAttribute("NOW", now);
		
		User loginUser = (User)session.getAttribute(SessionNames.LOGIN);
		if (null != loginUser) {
			String uname = service.getUname(loginUser.getUid());
			model.addAttribute("UNAME", uname);
			
			// select * from User where uid = #{uid}
			User loginInfoUser = service.getLoginInfo(loginUser.getUid());
			model.addAttribute("loginIP", loginInfoUser.getLoginip());
			model.addAttribute("loginTime", loginInfoUser.getLastlogin());
		}
	}
	
	@RequestMapping(value = "/dummy10", method = RequestMethod.GET)
	public String dummy10(RedirectAttributes rttr) throws Exception {
		logger.info("dummy10 .....");
		service.dummy10();
		rttr.addFlashAttribute("msg", "dummy10-ok");
		return "redirect:/board/listAll";
	}

}
