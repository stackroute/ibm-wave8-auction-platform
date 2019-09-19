import { Upload } from './upload';
import * as firebase from 'firebase/app';
import { Injectable } from '@angular/core';
import { AngularFireStorage, AngularFireStorageReference, AngularFireUploadTask } from 'angularfire2/storage';
import { finalize } from 'rxjs/operators';
import { Observable } from 'rxjs';
 
@Injectable()
export class UploadService {
  ref: AngularFireStorageReference;
  task: AngularFireUploadTask;
  imageUrl: any;
  downloadURL: Observable<string>

  constructor(private af: AngularFireStorage) { }

  private basePath:string = '/uploads';

  upload(file, username) {
    const id = Math.random();
    this.ref = this.af.ref(username + id);
    this.task = this.ref.put(file);
    console.log(this.task);
    this.task.snapshotChanges().pipe(
      finalize(() => {
        this.downloadURL = this.ref.getDownloadURL(),
        console.log(this.downloadURL);
      }))
    .subscribe();
  }
}