import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../service/data.service';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import $ from 'jquery';
import { Router } from '@angular/router';

@Component({
  selector: 'app-biddingpage',
  templateUrl: './biddingpage.component.html',
  styleUrls: ['./biddingpage.component.scss']
})
export class BiddingpageComponent implements OnInit {
  private serverUrl = 'http://172.23.238.216:8080/socket'
  private title = 'WebSockets chat';
  private stompClient;
  private bidAmount;
  private bidDay;
  private combined;

  @Input() item;
  constructor(private data: DataService, 
    private router:Router) { this.initializeWebSocketConnection(); }

  ngOnInit() {
    this.data.getItem().subscribe(data =>{
      this.item=data
      console.log(this.item)
    });
  }

  itemUpdater(bidValue, daysRent, biddername, bidderEmailId, bidderPhoneNumber)
  {
  
    // console.log(bidValue);
    this.data.updateItem(bidValue,daysRent, biddername, bidderEmailId, bidderPhoneNumber).subscribe(data=>this.item=data);
  //  this.data.getItem()
  //  .subscribe(data=>this.item=data,
  //   );
  }
  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;

    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat", (message) => {
        
        if(message.body) {
          //$(".chat").append("<div class='form-field'>"+message.body+"</div>")
           this.bidAmount = message.body;
           this.bidAmount = this.bidAmount.split("-");

          // console.log(this.bidAmount);

          document.getElementById('latest-bid').innerHTML= this.bidAmount[1];

          document.getElementById('latest-day').innerHTML= this.bidAmount[2];
        }
      });
    });

    }

  sendMessage1(message1,message2){
    console.log(message1,message2)
    this.combined = message1+"-"+message2;
    console.log(this.combined);


    this.stompClient.send("/app/send/message" , {}, this.combined);
    $('#yourBidInput').val('');

    
  }

  

}