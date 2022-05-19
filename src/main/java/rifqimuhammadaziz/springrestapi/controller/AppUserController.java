package rifqimuhammadaziz.springrestapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springrestapi.dto.AppUserData;
import rifqimuhammadaziz.springrestapi.dto.ResponseData;
import rifqimuhammadaziz.springrestapi.model.entity.AppUser;
import rifqimuhammadaziz.springrestapi.model.entity.AppUserRole;
import rifqimuhammadaziz.springrestapi.service.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController{

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData) {
        ResponseData<AppUser> response = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        response.setPayload(appUserService.registerUser(appUser));
        response.setStatus(true);
        response.getMessages().add("New User saved!");
        return ResponseEntity.ok(response);
    }
}
