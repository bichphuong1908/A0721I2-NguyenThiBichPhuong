import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {IRatingUnit} from "../irating-unit";

@Component({
  selector: 'app-rating-bar-component',
  templateUrl: './rating-bar-component.component.html',
  styleUrls: ['./rating-bar-component.component.css']
})
export class RatingBarComponentComponent implements OnInit {

  @Output()
  ratingEvent = new EventEmitter<number>();
  rating: IRatingUnit[] = IRatingUnit.rating;

  constructor() { }

  ngOnInit(): void {
  }


  getData(value: number) {
    this.ratingEvent.emit(value);
    for (let i = 0;  i < value; i++){
      this.rating[i].action = 1;
    }
  }
}
