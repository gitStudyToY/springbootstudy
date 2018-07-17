package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.inter.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    @ApiOperation(value = "新增一个用户",notes = "新增一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名称",dataType = "String",required = true,paramType = "query"),
            @ApiImplicitParam(name = "age",value = "用户年龄",dataType = "Integer",required = true,paramType = "query")
    })
    @GetMapping("createUser/{name}/{age}")
    void create(@RequestParam("name") String name, @RequestParam("age") int age){
        userService.create(name,age);
    }

    /**
     * 根据name删除一个用户
     * @param name
     */
    @ApiOperation(value = "根据name删除一个用户",notes = "根据name删除一个用户")
    @ApiImplicitParam(name = "name",value = "用户名称",required = true,dataType = "String",paramType = "query")
    @GetMapping("deleteByName/{name}")
    void deleteByName(@RequestParam("name") String name){
        userService.deleteByName(name);
    }

    /**
     * 获取用户总量
     */
    @ApiOperation(value = "获取用户总量" ,notes = "获取用户总量")
    @GetMapping("getAllUsers")
    Integer getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * 删除所有用户
     */
    @ApiOperation(value = "删除所有用户",notes = "删除所有用户")
    @GetMapping("deleteAllUsers")
    void deleteAllUsers(){
        userService.deleteAllUsers();
    }

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }


} 