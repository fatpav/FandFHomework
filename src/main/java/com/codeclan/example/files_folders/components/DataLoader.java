package com.codeclan.example.files_folders.components;


import com.codeclan.example.files_folders.models.File;
import com.codeclan.example.files_folders.models.Folder;
import com.codeclan.example.files_folders.models.User;
import com.codeclan.example.files_folders.repositories.FileRepository;
import com.codeclan.example.files_folders.repositories.FolderRepository;
import com.codeclan.example.files_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User pav = new User("Pavel Fatterson");
        userRepository.save(pav);

        User amy = new User("Amy Amerson");
        userRepository.save(amy);

        User lamey = new User("Lamus Lamelyford");
        userRepository.save(lamey);

        Folder pics = new Folder("Pictures", amy);
        folderRepository.save(pics);

        Folder games = new Folder("Games", pav);
        folderRepository.save(games);

        Folder videos = new Folder("Videos", lamey);
        folderRepository.save(videos);

        File nudie = new File("Nudey_Pic", ".jpeg", 256, pics);
        fileRepository.save(nudie);

        File clothed = new File("Clothed_Pic", ".bmp", 756, pics);
        fileRepository.save(clothed);

        File holiday = new File("Holiday_Snap", ".jpeg", 256, pics);
        fileRepository.save(holiday);

        File video1 = new File("Star_Wars", ".mp4", 3000, videos);
        fileRepository.save(video1);

        File video2 = new File("Savin_Private_Ryan", ".mpeg", 4500, videos);
        fileRepository.save(video2);

        File game1 = new File("Doom", ".exe", 5000, games);
        fileRepository.save(game1);

        File game2 = new File("Football_Manager", ".exe", 3250, games);
        fileRepository.save(game2);
    }
}
