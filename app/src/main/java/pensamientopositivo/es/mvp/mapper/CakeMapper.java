package pensamientopositivo.es.mvp.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pensamientopositivo.es.mvp.mvp.model.Cake;
import pensamientopositivo.es.mvp.mvp.model.CakeResponseCakes;
import pensamientopositivo.es.mvp.mvp.model.CakesResponse;
import pensamientopositivo.es.mvp.mvp.model.Storage;

/**
 * Created by pablo on 8/1/17.
 */

public class CakeMapper {

    @Inject
    public CakeMapper(){

    }

    public List<Cake> mapCakes(Storage storage,CakesResponse response){
        List<Cake> cakeList = new ArrayList<>();
        if(response!=null){
            CakeResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakeResponseCakes cakes : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cakes.getId());
                    myCake.setDetailDescription(cakes.getDetailDescription());
                    myCake.setImageUrl(cakes.getImage());
                    myCake.setPreviewDescription(cakes.getPreviewDescription());
                    myCake.setTitle(cakes.getTitle());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }

}
