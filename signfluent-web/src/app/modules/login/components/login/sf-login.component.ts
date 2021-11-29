import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthorizationService } from "src/app/authorization/sf-authorization.service";
import { SessionService } from "src/app/modules/core/services/sf-session.service";
import { RoleService } from "src/app/modules/users/services/sf-role.service";
import { SignfluentErrorStateMatcher } from "../../../../util/signfluent-error-state-matcher";


@Component({
    selector: 'sf-login',
    templateUrl: './sf-login.component.html',
    styleUrls: ['./sf-login.component.scss']
})

export class SfLoginComponent {

    loginForm!: FormGroup;
    matcher = new SignfluentErrorStateMatcher();
    isLoadingResults = false;

    constructor(private authService: AuthorizationService, private formBuilder: FormBuilder, private router: Router, private sessionService: SessionService) { }

    public ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: [null, Validators.required],
            password: [null, Validators.required]
        })
    }

    public login() {
        this.isLoadingResults = true;
        this.authService.login(this.loginForm.value)
            .subscribe(() => {
                this.isLoadingResults = false;
                this.sessionService.saveRoles();
                this.router.navigate(['/signfluent'])
            })
    }

}
