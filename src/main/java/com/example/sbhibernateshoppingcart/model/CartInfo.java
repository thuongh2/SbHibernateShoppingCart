package com.example.sbhibernateshoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInfo {
    private int orderNum;

    private CustomerInfo customerInfo;

    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    private CartLineInfo findLineByCode(String code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getCode().equals(code)) {
                return line;
            }
        }
        return null;
    }

    private void addProduct(ProductInfo productInfo, int quantity){
        CartLineInfo lineInfo = this.findLineByCode(productInfo.getCode());

        if(lineInfo == null){
            lineInfo = new CartLineInfo();
            lineInfo.setQuantity(0);
            lineInfo.setProductInfo(productInfo);
            this.cartLines.add(lineInfo);
        }

        int newQuantity = lineInfo.getQuantity() + quantity;
        if(newQuantity <=0){
            this.cartLines.remove(lineInfo);
        }else {
            lineInfo.setQuantity(newQuantity);
        }
    }

    public void updateProduct(String code, int quantity){
        CartLineInfo lineInfo = this.findLineByCode(code);

        if(lineInfo != null){
            if(quantity <= 0){
                this.cartLines.remove(lineInfo);
            }
            else {
                lineInfo.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(ProductInfo productInfo){
        CartLineInfo lineInfo = this.findLineByCode(productInfo.getCode());
        if(lineInfo != null){
            this.cartLines.remove(lineInfo);
        }
    }

    public boolean isEmpty(){
        return this.cartLines.isEmpty();
    }

    private boolean isValidCustomer(){
        return  this.customerInfo != null && this.customerInfo.isValid();
    }

    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }

    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
            }
        }
    }
}
