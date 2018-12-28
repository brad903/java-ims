package codesquad.web;

import codesquad.domain.Issue;
import codesquad.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/issues")
public class IssueController {
    @Resource(name = "issueService")
    private IssueService issueService;

    @GetMapping("/form")
    public String createForm() {
        return "issue/form";
    }

    @PostMapping("")
    public String create(@Valid Issue issue) {
        issueService.add(issue);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("issue", issueService.findById(id));
        return "issue/show";
    }
}
