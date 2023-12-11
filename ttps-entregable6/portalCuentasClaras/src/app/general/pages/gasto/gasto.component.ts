import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-gasto',
  templateUrl: './gasto.component.html',
  styles: [
  ]
})
export class GastoComponent implements OnInit {

  constructor( private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params
      .subscribe( ({ id }) => console.log(id) );
  }

}
