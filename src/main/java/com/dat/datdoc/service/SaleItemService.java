package com.dat.datdoc.service;

import com.dat.datdoc.model.SaleItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SaleItemService {

    private static final String ITENS_ON_SALE_SPLITTER = ",";
    private static final String DETAIL_SALE_ITEM_SPLITTER = "-";

    /**
     * Method responsible for split the infos comming from the document.
     *
     * @param itensOnSale infos comming from the document.
     *
     * @return List of Sale Itens.
     */
    public List<SaleItem> splitItemsOnSale(String itensOnSale){
        List<SaleItem> saleItemsList = new ArrayList<>();

        if (Objects.nonNull(itensOnSale)) {
            String[] itemListSplited = itensOnSale.split(ITENS_ON_SALE_SPLITTER);

            for (String item : itemListSplited) {
                saleItemsList.add(splitSaleItem(item));
            }
            return saleItemsList;
        }
         return null;
    }

    private SaleItem splitSaleItem(String itemListSplited) {
        String[] detailItemSplited = itemListSplited.split(DETAIL_SALE_ITEM_SPLITTER);

        SaleItem saleItem = new SaleItem();

        saleItem.setId(detailItemSplited[0]);
        saleItem.setItemQuantity(Integer.valueOf(detailItemSplited[1]));
        saleItem.setItemPrice(new BigDecimal(detailItemSplited[2]));

        return saleItem;
    }
}
