import { Component, OnInit, ViewChild } from '@angular/core';
import { connectService } from './connect.service';

import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.css']
})
export class Comp1Component implements OnInit {

  input:String = "";
  output;
  curPage = 1;
  pageSize = 10;
  numberOfPages = 1;
  constructor(private cservice: connectService) { }

  ngOnInit() {
  }
  submit(){
    if(this.input.length != 7 && this.input.length != 10){
      window.alert("The input should be 7 or 10 digits number");
      return;
    }
    if(!this.validateInput()){
      window.alert("The input should be only number");
      return;
    }
    this.cservice.getStringList(this.input).subscribe(
      data => {this.output = data;
        this.numberOfPages = Math.ceil(this.output.length / this.pageSize);
      },
      err => console.log(err),
      () => console.log(this.output),
    );
  }

  validateInput(){
    if(!isNaN(Number(this.input))){
      return true;
    }
    else{
      return false;
    }
  }

}
