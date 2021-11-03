import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthorizationService } from "src/app/authorization/sf-authorization.service";
import { SignfluentErrorStateMatcher } from "../../../../util/signfluent-error-state-matcher";


@Component({
    selector: 'sf-login',
    templateUrl: './sf-login.component.html',
    styleUrls: ['./sf-login.component.scss']
})

export class SfLoginComponent {

    loginForm!: FormGroup;
    matcher = new SignfluentErrorStateMatcher();

    constructor(private authService: AuthorizationService, private formBuilder: FormBuilder, private router: Router) { }

    public ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: [null, Validators.required],
            password: [null, Validators.required]
        })
    }

    public login() {
         this.authService.login(this.loginForm.value)
           .subscribe(() => {
                 this.router.navigate(['/signfluent'])
               })
    }

}
