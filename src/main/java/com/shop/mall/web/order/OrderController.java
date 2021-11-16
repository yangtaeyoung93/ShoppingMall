package com.shop.mall.web.order;

import com.shop.mall.domain.Order;
import com.shop.mall.domain.OrderSearch;
import com.shop.mall.domain.item.Item;
import com.shop.mall.domain.member.Member;
import com.shop.mall.domain.member.MemberForm;
import com.shop.mall.service.ItemService;
import com.shop.mall.service.MemberService;
import com.shop.mall.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final ItemService itemService;
    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("/order/{memberId}")
    public String createForm(@PathVariable("memberId") Long memberId, Model model){
        Member member = memberService.findOne(memberId);

        MemberForm memberForm = new MemberForm();
        memberForm.setName(member.getName());
        memberForm.setLoginId(member.getLoginId());
        memberForm.setCity(member.getAddress().getCity());
        memberForm.setStreet(member.getAddress().getStreet());
        memberForm.setZipcode(member.getAddress().getZipcode());

        List<Item> items = itemService.findAll();

        model.addAttribute("memberId", memberId);
        model.addAttribute("member", memberForm);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count){

       orderService.order(memberId, itemId, count);
       return "redirect:/order/" + memberId;

    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute OrderSearch orderSearch, Model model){
        List<Order> orders = orderService.findAllWithItem(orderSearch);
        model.addAttribute("orders",orders);

        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId){
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
