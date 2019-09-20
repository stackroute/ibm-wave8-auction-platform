import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js';
@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.scss']
})
export class StatsComponent implements OnInit {
 

  BarChart:any;
  LineChart:any;
PieChart:any;
  constructor() { }

  ngOnInit(){
    // pie chart:
this.PieChart = new Chart('pieChart', {
  type: 'pie',
data: {
 labels: [ "MALE", "FEMALE"],
 datasets: [{
     label: 'Based on Gender',
     data: [100,70],
     backgroundColor: [
        'blue',
        'pink'
         
     ],
     borderColor: [
        
         'rgba(153, 102, 255, 1)',
         'rgba(255, 159, 64, 1)'
     ],
     borderWidth: 1
 }]
}, 
options: {
 title:{
     text:"Gender",
     display:true
 },
 scales: {
     yAxes: [{
         ticks: {
             beginAtZero:true
         }
     }]
 }
}
});

  
    // Line chart:
this.LineChart = new Chart('lineChart', {
  type: 'line',
data: {
 labels: ["Jan", "Feb", "March", "April", "May", "June","July","Aug","Sep","Oct","Nov","Dec"],
 datasets: [{
     label: 'Bids',
     data: [6,8,5,9,10,15,20,17,18],
     fill:false,
     lineTension:0.2,
     borderColor:"red",
     borderWidth: 1
 }]
}, 
options: {
 title:{
     text:"Number of Users ",
     display:true
 },
 scales: {
     yAxes: [{
         ticks: {
             beginAtZero:true
         }
     }]
 }
}
});
//barchart
    
    this.BarChart = new Chart('barChart', {
      type: 'bar',
    data: {
     labels: ["Jan", "Feb", "March", "April", "May", "June","July","Aug","Sep","Oct","Nov","Dec"],
     datasets: [{
         label: 'Bids this year',
         data: [100,300,200,400,500,700,900,999,1200],
         backgroundColor: [
            'red',
            'yellow',
            'green',
            'pink',
            'orange',
            'purple',
            'black',
            'blue',
            'grey'
             
         ],
         borderColor: [
             'rgba(255,99,132,1)',
             'rgba(54, 162, 235, 1)',
         ],
         borderWidth: 1
     }]
    }, 
    options: {
     title:{
         text:"Total Number of Bids",
         display:true
     },
     scales: {
         yAxes: [{
             ticks: {
                 beginAtZero:true
             }
         }]
     }
    }
    });
  }
}    

