package idv.heartisan.test.exam.web;

import idv.heartisan.test.exam.pojo.R;
import idv.heartisan.test.exam.pojo.dto.req.RegisterDTO;
import idv.heartisan.test.exam.pojo.dto.req.RegisterDTO2;
import idv.heartisan.test.exam.service.app.ActorAppService;
import idv.heartisan.test.exam.validator.RegisterByEmail;
import idv.heartisan.test.exam.validator.RegisterByPhone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jin Qi
 * @date 2022/7/22
 */

@RestController
@RequestMapping("/actor")
@Slf4j
public class ActorController {

    @Autowired
    private ActorAppService actorAppService;

    @PostMapping(name = "注册", path = "/register")
    public R register(@Valid @RequestBody RegisterDTO registerDTO) {
        return actorAppService.register(registerDTO);
    }


    @PostMapping(name = "手机号注册", path = "/registerByPhone")
    public R registerByPhone(@Validated(RegisterByPhone.class) @RequestBody RegisterDTO2 registerDTO) {
        return R.ok();
    }

    @PostMapping(name = "邮箱注册", path = "/registerByEmail")
    public R registerByEmail2(@Validated(RegisterByEmail.class) @RequestBody RegisterDTO2 registerDTO) {
        return R.ok();
    }

}
