/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Joke;
import java.util.List;


/**
 *
 * @author Younes
 */
public interface IjokesFacade {
   
    List<Joke> getAllJokes();
    Joke getJokeById(int id);
    Joke getJokeByReference();
    Joke getJokeByType();
    Joke getRandomJoke();

    
}
