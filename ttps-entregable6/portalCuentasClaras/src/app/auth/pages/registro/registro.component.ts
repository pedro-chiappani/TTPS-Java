import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styles: [
    `
    .overlay {
      background-color: white; /* Fondo opaco */
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .example-form {
      background-color: rgba(0, 0, 0, 0.1);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
    }
    
    .example-form .example-full-width{
      width:100%;
      margin-bottom:15px;    
    }

    `
  ]
})
export class RegistroComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  username='';
  password='';
  email='';
  name='';
  lastname='';

  onSubmit(){
    console.log(this.username);
    console.log(this.password);
  }

}
