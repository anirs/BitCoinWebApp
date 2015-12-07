package com.mybitcoin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TimerService;

import org.joda.money.CurrencyUnit;

import com.coinbase.api.Coinbase;
import com.coinbase.api.CoinbaseBuilder;
import com.coinbase.api.entity.Account;
import com.coinbase.api.entity.AccountsResponse;
import com.coinbase.api.exception.CoinbaseException;

@Singleton
public class BTTimer {
	
	static private String publicKey="b327f2f291b730291e3f617e9ce24cd3";
	static private String passphrase="bxgyhwmjgeo";
	static private String secretKey="U/vmm8LQUuukvopx8OtDZZAyaI0TsIFfKdNuN1GjwESvKDFRQQ4YlH/2MzrN1xlNNV+2bxThE0+83J0hhnhkSQ==";

	static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	static String apiKey = "cDTe0pGqsxBxMS3l";
	static String apiSecret = "9g2JtmKDsPaxr0P0vsuwtIrKkS1s2wzq";
	
	@Resource
    TimerService timerService;
	
    @Schedule(second="*/10", minute="*",hour="*", persistent=false)
    public void doAction() throws IOException, CoinbaseException{
        System.out.println("Call TIME: "+new Date());
        System.out.println("RUN ...:");
        runXChange();
    }
    
    public static void runXChange() throws IOException, CoinbaseException{
    	Coinbase cb = new CoinbaseBuilder().withApiKey(apiKey,apiSecret).build();
		System.out.println("User Email : " +cb.getUser().getEmail());
		//AccountsResponse accountsRes = cb.getAccounts();
		BigDecimal currentPrice = cb.getSpotPrice(CurrencyUnit.CAD).getAmount();
		
		System.out.println("Current Price : " +currentPrice);
		/*for(Account account : accountsRes.getAccounts()){
			System.out.println("Account Name :"+account.getName());
			System.out.println("Total Amount in BTC : "+account.getBalance().getAmount());					
			System.out.println("Total Amount in CAD : " + formatter.format((account.getBalance().getAmount().doubleValue()) * (currentPrice.doubleValue())));
		}
		
		CoinbaseExchangeBuilder cbeb = new CoinbaseExchangeBuilder();
		cbeb.useDefault();
		cbeb.withAPIKeyAndPassphrase(publicKey, secretKey, passphrase);
		CoinbaseExchange cbex =  cbeb.build();
		for(com.coinbase.exchange.api.entity.Account ac : cbex.getAccounts()){
			System.out.println("Account ID : "+ac.getId());
			System.out.println("Account Currency : "+ac.getCurrency()+" "+ ac.getBalance());
			//System.out.println("Account  Balance : ");
			
		}
		System.out.println("Fill size :"+cbex.getFills().length);
		
		for(Fill fill: cbex.getFills())
		{
			System.out.println("Size : "+fill.getSize() + " Price:"+fill.getPrice()+" Fee :"+fill.getFee()+" Time:"+fill.getCreated_at()+" Side :"+fill.getSide());
		}
		for(Product product: cbex.getProducts())
		{
			if(product.getId().equals("BTC-CAD")){
			System.out.println(product.getId()+" "+product.getBase_max_size()+" "+product.getBase_min_size());
			Stats stats= cbex.getStats(product);
			System.out.println(" Hight :"+stats.getHigh()+" Low :"+stats.getLow()+" Open:"+stats.getOpen()+" Volumn :"+stats.getVolume());
			//OrderBook orderbook = cbex.getOrderBook(product, 2);
			//System.out.println(cbex.getMarketDataOrderBook(product.getId(),"2"));
			ProductOrderBook  productOrderBook = cbex.getMarketDataProductOrderBook(product.getId(),"2");
			System.out.println("================= Asks =================");
			for(List<String> asks : productOrderBook.getAsks()){
				System.out.println("Price:"+asks.get(0)+" Size:"+asks.get(1)+" Order#:"+asks.get(2));
			}
			System.out.println("================= Bids =================");
			for(List<String> bids : productOrderBook.getBids()){
				System.out.println("Price:"+bids.get(0)+" Size:"+bids.get(1)+" Order#:"+bids.get(2));
			}
			for(Ask ask :orderbook.getAsks()){
				System.out.println(ask.getPrice()+" " + ask.getNum_orders()+ " "+ask.getSize());
			}
			}			
		}*/
		//Authentication auth = new Authentication(publicKey,secretKey,passphrase);
		//auth.setAuthenticationHeaders(request, method, endpoint_url);
    }
}
