import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.scss']
})
export class TrendingComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    //this.slides = this.chunk(this.cards, 3);
  }
}
//   cards = [
//     {
//       title: 'Iphone 8 plus',
//       description: 'Used for 1 year',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'Wallclock',
//       description: 'Used for 6 months',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'Level Earphones',
//       description: 'Used for 1 year',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'Chevorlet SUV',
//       description: 'Used for 15 months',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'IFB Washing Machine',
//       description: 'Used for 5 months',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'One Plus 7 Pro',
//       description: 'Used for 2 months',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'JBL Speakers',
//       description: 'Used for 6 months',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'Givenchy jacket',
//       description: 'Used for 1 month',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//     {
//       title: 'Samsung LED Tv',
//       description: 'Used for 1 year',
//       buttonText: 'Bid',
//       img: 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'
//     },
//   ];

//   slides: any = [[]];
  
//   chunk(arr, chunkSize) {
//     let R = [];
//     for (let i = 0, len = arr.length; i < len; i += chunkSize) {
//       R.push(arr.slice(i, i + chunkSize));
//     }
//     return R;
//   }
 
// }

