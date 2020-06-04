package com.example.swagger;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags = "User Data Interface")
public class UserController {
    @ApiOperation(value = "findUser", notes = "Find a user by ID")
    @ApiImplicitParam(paramType = "path", name = "id",
    value = "userID", required = true)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id) {
        return "/user/" + id;
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "Delete succeed!"),
            @ApiResponse(code = 500, message = "Delete fail!")})
    @ApiOperation(value = "deleteUser", notes = "Delete a User by ID")
    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return id;
    }
    @ApiOperation(value = "addUser",
    notes = "Add a User by passing username and address")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "username",
            value ="username", required = true, defaultValue = "defaultUser"),
            @ApiImplicitParam(paramType = "query",name = "address",
            value = "address",required = true, defaultValue = "defaultAddress")})
    @PostMapping("/user")
    public String addUser(@RequestParam String username,
                          @RequestParam String address) {
        return username + ":" + address;
    }
    @ApiOperation(value="updateUser", notes = "update a user by passing user info")
    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        return user.toString();
    }
    @GetMapping("/ignore")
    @ApiIgnore
    public void ignoreMethod() {
    }
}
