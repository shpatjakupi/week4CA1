/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.JokeDTO;
import entities.Joke;
import java.util.List;


/**
 *
 * @author Younes
 */
public interface IjokesFacade {
   
    List<JokeDTO> getAllJokes();
    JokeDTO getJokeById(int id);
    List<JokeDTO> getJokeByReference(String reference);
    List<JokeDTO> getJokeByType(String type);
    JokeDTO getRandomJoke();
    Joke addJoke(Joke joke);
    void populateJokes();

    
}
