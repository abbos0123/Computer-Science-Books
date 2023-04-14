package uz.uniquecode.serviceb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.uniquecode.serviceb.model.Poet;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Service
@RequiredArgsConstructor
public class PoetService {
    List<Poet> list = new ArrayList<>();

    {
        for (int i = 0; i < 20; i++) {
            Poet poet = Poet.builder()
                    .id(i)
                    .name("Poet-" + i)
                    .text(String.format("This is text of poet %d.", i))
                    .author("Author of this poet is Veladimr " + i)
                    .year(1997 + i)
                    .build();
            list.add(poet);
        }
    }

    public List<Poet> findAllPoets(){
        return list;
    }

    public Poet findById(Integer id){
        if (id == null) throw new NullPointerException("Id can not be null");
        if (id >= 0 && id <20)
            return list.get(id);
        throw new RuntimeException("Poet with this id does not exits !!!");
    }
}
