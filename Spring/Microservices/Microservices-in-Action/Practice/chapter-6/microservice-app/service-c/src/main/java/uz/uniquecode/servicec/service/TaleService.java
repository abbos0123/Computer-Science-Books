package uz.uniquecode.servicec.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.uniquecode.servicec.model.Tale;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Service
@RequiredArgsConstructor
public class TaleService {
    List<Tale> list = new ArrayList<>();

    {
        for (int i = 0; i < 20; i++) {
            Tale tale = Tale.builder()
                    .id(i)
                    .name("Tale-" + i)
                    .text(String.format("This is text of tale %d.", i))
                    .author("Public work ...")
                    .year(1799 + i)
                    .build();
            list.add(tale);
        }
    }

    public List<Tale> findAllPoets(){
        return list;
    }

    public Tale findById(Integer id){
        if (id == null) throw new NullPointerException("Id can not be null");
        if (id >= 0 && id <20)
            return list.get(id);
        throw new RuntimeException("Tale with this id does not exits !!!");
    }
}
