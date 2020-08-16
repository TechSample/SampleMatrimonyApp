# SampleMatrimonyApp

This app is Sample Matrimony App made using MVVM Pattern with RxData, Room Local Database with Kotlin

Dashboard page : 

It will fetch all members list from API and store it into Local Database

Three Tabs : 

1. All Matches Tab - This tab will list down all the available members which can be accepted or declined.
  - On click of - Acccept Button , it will add that member to accepted list and text of the button will now show - Member Accepted. Decline button will be disabled.
  - On click of - Decline Button , it will add that member to declined list and text of the button will now show - Member Declined. Acccept button will be disabled.

2. Accepted Tab - This tab will list down all the available accepted members. If none, it will show - No Accepted Matches.
3. Declined Tab - This tab will list down all the available declined members. If none, it will show - No Declined Matches.

![all_matches_tab_wth_accept_decline_buttons](https://user-images.githubusercontent.com/43431244/90332358-b5402a80-dfd9-11ea-8f0c-9d11bb4542fb.png)
![member_accepted_text_btn](https://user-images.githubusercontent.com/43431244/90332360-c38e4680-dfd9-11ea-8697-6976f72710fd.png)
![member_declined_text_btn](https://user-images.githubusercontent.com/43431244/90332364-cdb04500-dfd9-11ea-95b4-dc80525d3566.png)
![accepted_member_tab](https://user-images.githubusercontent.com/43431244/90332366-d6a11680-dfd9-11ea-962f-95a687edd9da.png)
![declined_member_tab](https://user-images.githubusercontent.com/43431244/90332371-e02a7e80-dfd9-11ea-8686-04f23152fad6.png)


![matrimony_app](https://user-images.githubusercontent.com/43431244/90332698-ae66e700-dfdc-11ea-8f37-6ead25a0e9b0.gif)
