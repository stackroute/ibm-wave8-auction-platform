import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, FormGroupDirective, NgForm } from '@angular/forms';
import { IProduct } from '../models/product';
import { ActivatedRoute, Router } from '@angular/router';
import { RentItemsService } from '../service/rent-items.service';
import { UploadService } from '../uploads/shared/upload.service';
import { Observable } from 'rxjs';
import { AngularFireStorage, AngularFireUploadTask } from 'angularfire2/storage';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-rent-items',
  templateUrl: './rent-items.component.html',
  styleUrls: ['./rent-items.component.scss']
})
export class RentItemsComponent implements OnInit {
  selectedFile = null;
  rentitemsForm: FormGroup;
  imageUrl: Observable<string>;
  private fileRef: any;
  private username: string;
  private filePath: any;
  private itemImageUrl: string;

  // Download URL
  downloadURL: Observable<string>;
  rentItems = new IProduct();
  constructor(private uploadService: UploadService, private rentItemsService: RentItemsService, private formBuilder: FormBuilder, private route: ActivatedRoute,
    private router: Router, private storage: AngularFireStorage) {
    this.username = this.route.snapshot.params.id;
    console.log(this.username);
  }
  ngOnInit() {
    this.rentitemsForm = new FormGroup({
      itemName: new FormControl("",[Validators.required]),
      itemQuantity: new FormControl("",[Validators.required]),
      itemDurationOfRent: new FormControl("",[Validators.required]),
      baseRent: new FormControl("",[Validators.required]),
      itemDescription: new FormControl("",[Validators.required]),
      itemCategory: new FormControl("",[Validators.required]),
      itemImageUrl: new FormControl()
    })
  }

  onFileSelected(event) {
    this.filePath = this.username + Math.random();
    this.selectedFile = event.target.files[0];
    let task = this.storage.ref(this.filePath).put(this.selectedFile)
    // get notified when the download URL is available
    task.snapshotChanges().pipe(
      finalize(() => {
        this.downloadURL = this.storage.ref(this.filePath).getDownloadURL(),
          this.downloadURL.subscribe(data => {
            const imageUrl = data;
            this.itemImageUrl = imageUrl;
            console.log(imageUrl);
            //this.rentItems.itemImageUrl = this.rentitemsForm.get('itemImageUrl').value;

          });
      })
    )
      .subscribe()


  }

  submitRentItems() {
    alert("Your items have been submmited successfully!!");
    this.rentItems.itemName = this.rentitemsForm.get('itemName').value;
    this.rentItems.itemQuantity = this.rentitemsForm.get('itemQuantity').value;
    this.rentItems.itemDurationOfRent = this.rentitemsForm.get('itemDurationOfRent').value;
    this.rentItems.baseRent = this.rentitemsForm.get('baseRent').value;
    this.rentItems.itemDescription = this.rentitemsForm.get('itemDescription').value;
    this.rentItems.itemCategory = this.rentitemsForm.get('itemCategory').value;
    //this.rentItems.itemImageUrl = this.rentitemsForm.get('itemImageUrl').value;
    console.log(this.itemImageUrl);
    this.rentItems.itemImageUrl=this.itemImageUrl;
    //this.itemImageUrl = this.
    // this.uploadService.upload(this.selectedFile, this.username);
    this.rentItemsService.uploadRentItems(this.rentItems, this.username)
      .subscribe(
        response => console.log(response),
        error => console.log(error)
      )
    console.log(this.rentItems);
  }
  check()
{
  this.router.navigate(['landing/'+this.username]);
}
}
