import {
  MatButtonModule,
  MatCheckboxModule,
  MatIconModule,
  MatToolbarModule,
  MatChipsModule,
  MatCardModule,
  MatGridListModule,
  MatTableModule,
  MatTooltipModule,
} from '@angular/material';

import { NgModule } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import { MatDialogModule } from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
  


@NgModule({
 
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatToolbarModule,
    MatChipsModule,
    MatCardModule,
    MatGridListModule,
    MatTableModule,
    MatTooltipModule,
    MatInputModule,
    MatMenuModule, 
    MatDialogModule
  ],
  exports: [MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatToolbarModule,
    MatChipsModule,
    MatCardModule,
    MatGridListModule,
    MatTableModule,
    MatTooltipModule,
    MatInputModule,
  MatMenuModule, 
  MatDialogModule
]
})
export class MaterialModule { }
