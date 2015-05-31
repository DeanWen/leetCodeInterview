/*
Given a data file containing hotel deals, write an app to find the best applicable deal 
for the user and return the promo_txt for the deal. 
You will need to consider the type of deal, valid dates, hotel name, and edge cases. 
If no deal applies you will return “no deals available”. You may assume the entire deals 
file fits in memory. You may use Java, C++, C#, or Python for your solution with 
the standard libraries at your disposal.

The types of deals are as follows:
    rebate : a straight discount off the total price of the stay
    rebate_3plus : a straight discount off the total price when the duration of stay is >= 3
    pct : a percentage discount off the total price of the stay

The deals data file will be a comma-separated file (CSV) in the following format:
hotel_name,nightly_rate,promo_txt,deal_value,deal_type,start_date,end_date
Hotel Commonwealth,250,$50 off your stay 3 nights or more,-50,rebate_3plus,2014-06-01,2014-07-31
Hotel Commonwealth,250,5% off your stay,-5,pct,014-06-01,2014-06-15
Hotel Commonwealth,250,$25 off your stay,-25,rebate,2014-07-07,2014-07-31   

The input to your application will be the path to the deal file, the hotel name, 
check in date, and number of nights stay. For example:
> BestHotelDeal ./deals.csv “Hotel Commonwealth” 2014-06-30 3

Any errors resulting from bad parameters and/or invalid deal file should be handled 
gracefully, with informative feedback to the user.
Examples:
> BestHotelDeal ./deals.csv  "Hotel Commonwealth" 2014-06-30 3
> $50 off your stay 3 nights or more
> BestHotelDeal ./deals.csv  "Hotel ABC" 2014-06-30 1
> 5% off your stay
> BestHotelDeal ./deals.csv  "Hotel ABC" 2014-06-30 2
> no deal available
*/