package com.airstack.ta.pojos.QueryPojo;

public class Token {
   private String id;
    private String address;
    private String chainId;
    private String name;
    private String symbol;
    private String type;
    private String totalSupply;
    private String decimals;
    private String baseURI;
    private String lastTransferTimestamp;
    private String lastTransferBlock;
    private String  lastTransferHash;
    private contractMetaData contractMetaData;
    private logo logo;
    private tokenBalances tokenBalances;
   private  pageInfo pageInfo;
  public Token(){
   this.pageInfo  =new pageInfo();
   this.contractMetaData = new contractMetaData();
   this.logo =  new logo();
   this.tokenBalances  = new tokenBalances();

  }

 @Override
 public String toString() {
  return "Token {"+ "\n" +
          "id"  + "\n" + 
          "address" + "\n" +
          "chainId"  + "\n" +
          "name" + "\n" +
          "symbol" + "\n" +
          "type" + "\n" +
          "totalSupply" + "\n" +
          "decimals" + "\n" +
          "baseURI" + "\n" +
          "lastTransferTimestamp" + "\n" +
          "lastTransferBlock" + "\n" +
          "lastTransferHash" + "\n" +
           contractMetaData + "\n" +
           logo + "\n" +
           tokenBalances + "\n" +
           pageInfo + "\n" +
          '}';
 }

 public static void main(String[] args) {
  System.out.println(new Token());
 }
}
