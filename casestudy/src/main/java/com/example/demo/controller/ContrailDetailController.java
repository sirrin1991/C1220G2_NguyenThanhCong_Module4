package com.example.demo.controller;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.contract.ContractDetailKey;
import com.example.demo.service.ContractDetailService;
import com.example.demo.service.ContractService;
import com.example.demo.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contract_detail")
public class ContrailDetailController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private IAttachService attachService;

    @Autowired
    private ContractDetailService contractDetailService;

    @ModelAttribute
    public void setUpItems(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/contract_detail/create", "contractDetail", new ContractDetail());
    }

    @PostMapping("/save")
    public String saveNewContractDetail(ContractDetail contractDetail) {
        int a = contractDetail.getContract().getId();
        int b = contractDetail.getAttachService().getId();
        ContractDetailKey c = new ContractDetailKey();
        c.setAttachServiceId(b);
        c.setContractId(a);
        contractDetail.setId(c);
        contractDetailService.save(contractDetail);
        return "redirect:";
    }
}
