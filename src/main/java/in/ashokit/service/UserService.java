package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public String getName(Integer id) {
		
		System.out.println(userdao.getClass().getName());

		String name = userdao.findName(id);

		System.out.println("Name :: " + name);

		return name;
	}
}
