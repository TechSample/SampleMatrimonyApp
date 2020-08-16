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

