package com.codeclan.example.files_folders;

import com.codeclan.example.files_folders.models.Folder;
import com.codeclan.example.files_folders.models.User;
import com.codeclan.example.files_folders.repositories.FileRepository;
import com.codeclan.example.files_folders.repositories.FolderRepository;
import com.codeclan.example.files_folders.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class FilesFoldersApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUserAndFolderThenSave(){

		User paul = new User("Paul");
		userRepository.save(paul);
		Folder games = new Folder("Games", paul);
		folderRepository.save(games);
	}

}
