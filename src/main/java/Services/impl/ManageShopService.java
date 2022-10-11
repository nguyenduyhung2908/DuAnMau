/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.ShopConverter;
import DomainModels.Shop;
import Repositories.IShopRepository;
import Repositories.impl.ShopRepository;
import Services.IManageShopService;
import ViewModels.ManageShop;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageShopService implements IManageShopService{
    private final IShopRepository shopRepository;
    private final ShopConverter shopConverter;

    public ManageShopService() {
        this.shopRepository = new ShopRepository();
        this.shopConverter = new ShopConverter();
    }
    
    @Override
    public List<ManageShop> findAll() {
        List<ManageShop> listResult = new ArrayList<>();
        List<Shop> listShop =  shopRepository.findAll();
        for(Shop s : listShop){
            ManageShop manageShop = shopConverter.toViewModel(s);
            listResult.add(manageShop);
        }
        return listResult;
    }

    @Override
    public String insert(ManageShop iShop) {
        Shop shop = shopConverter.toDomainModel(iShop);
        return this.shopRepository.insert(shop);
    }

    @Override
    public boolean update(ManageShop uShop) {
        Shop shop = shopConverter.toDomainModel(uShop);
        return this.shopRepository.update(shop);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.shopRepository.delete(codes);
    }
    
}
