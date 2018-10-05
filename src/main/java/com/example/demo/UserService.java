package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements Serializable {

    @Autowired
    UserRepoImpl userRepo;


    public UserService() {
    }

    //save file
    public void saveData()throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("data.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        oos.writeObject(userRepo.getMovies());


        oos.close();
        fos.close();
    }




    //read file
    public void getData() throws IOException, ClassNotFoundException{

        File f = new File("data.ser");
        if (f.exists()){

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Movie> temp = new ArrayList<>( (ArrayList<Movie>) ois.readObject());

            // copy
            for (int i = 0; i<temp.size();i++){
                userRepo.getMovies().add(temp.get(i));
            }


            ois.close();
            fis.close();

        }
    }










    // create
    public void create(Movie movie){
        userRepo.save(movie);
    }





    // delete
    public void delete(Movie movie){
        userRepo.getMovies().remove(movie);
    }






    // search
    public ArrayList<Movie> searchByTitle(String title){
        for (int i = 0; i<userRepo.getMovies().size();i++){

            if(userRepo.getMovies().get(i).getTitle().contains(title)){
                userRepo.getSearched().add(userRepo.getMovies().get(i));
            }
            return userRepo.getSearched();
        }

        return null;
    }

    public void clearSearch(){

            userRepo.getSearched().clear();
    }




    // get all
    public ArrayList<Movie> getMovies(){

        return userRepo.getMovies();

    }



    // get searched
    public ArrayList<Movie> getSearched(){

        return userRepo.getSearched();

    }


}
