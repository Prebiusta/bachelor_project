import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MatSnackBar } from "@angular/material/snack-bar";
import { UserService } from "src/app/modules/users/services/sf-user.service";
import { SfUser } from "src/app/modules/core/models/sf-user";

@Component({
    selector: 'sf-users-create',
    templateUrl: './sf-users-create.component.html',
    styleUrls: ['./sf-users-create.component.scss']
})

export class SfUsersCreateComponent {

    createUserForm: FormGroup;
    isLoadingResults = false;

    constructor(private formBuilder: FormBuilder, private userService: UserService, private snackbar: MatSnackBar) {
        this.createUserForm = this.formBuilder.group({
            "username": ["", Validators.required],
            "email": ["", Validators.required],
            "firstName": ["", Validators.required],
            "lastName": ["", Validators.required],
            "password": ["", Validators.required]
        })
    }

    createUser() {
        const user: SfUser = this.createUserForm.value;
        this.isLoadingResults = true;
        this.userService.createUser(user).subscribe({
            next: data => {
              this.isLoadingResults = false;
              this.snackbar.open("User sucessfully created", undefined, {
                duration: 5 * 1000
              });
            },
            error: error => {
              this.isLoadingResults = false;
              this.snackbar.open("Unable to create user", undefined, {
                duration: 5 * 1000
              });
            }
          });
    }

}