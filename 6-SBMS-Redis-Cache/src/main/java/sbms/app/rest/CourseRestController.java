package sbms.app.rest;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sbms.app.binding.User;

@RestController
public class CourseRestController {

	//private RedisTemplate<String, String> redisTemplate;
	private HashOperations<String,Integer,User> opsForHash;
	
	public CourseRestController(RedisTemplate<String, User> redisTemplate)
	{
		//this.redisTemplate=redisTemplate;
		opsForHash = redisTemplate.opsForHash();
	}
	
	@PostMapping("/user")
	public String storeData(@RequestBody User user)
	{
		opsForHash.put("PERSON", user.getUid(), user);
		return "success";
	}
	
	@GetMapping("/user/{uid}")
	public User getData(@PathVariable Integer uid)
	{
		User u=(User)opsForHash.get("PERSON", uid);
		return u;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return opsForHash.values("PERSON");
	}
	
	@DeleteMapping("/user/{uid}")
	public String deleteUser(@PathVariable Integer uid)
	{
		opsForHash.delete("PERSON", uid);
		return "User Deleted";
	}
}
