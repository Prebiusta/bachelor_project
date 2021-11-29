import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Base64Service } from "src/app/modules/core/services/base64.service";
import { SignfluentErrorStateMatcher } from "src/app/util/signfluent-error-state-matcher";
import { DocumentSigningProcessService } from "../../services/document-signing-process.service";

@Component({
  selector: 'sf-document-upload',
  templateUrl: './sf-document-upload.component.html',
  styleUrls: ['./sf-document-upload.component.scss']
})

export class SfDocumentUploadComponent {

  public fileName = '';
  private uploadedFile: any;
  public matcher = new SignfluentErrorStateMatcher();
  public descriptionFormControl!: FormGroup;
  public isLoadingResults = false;

  constructor(private signingProcessService: DocumentSigningProcessService, private base64Service: Base64Service, private snackbar: MatSnackBar, private builder: FormBuilder) {
  }

  ngOnInit() {
    this.descriptionFormControl = this.builder.group({
      description: [null, Validators.required],
      file: [null, Validators.required]
    })
  }

  public onFileSelected(event: any): void {
    const file = event.target.files[0];

    this.isLoadingResults = true;
    this.base64Service.fileToBase64(file)
      .then(encodedFile => {
        this.isLoadingResults = false;
        this.fileName = file.name;
        this.uploadedFile = encodedFile;
      })
      .catch(error => {
        this.isLoadingResults = false;
        this.snackbar.open("Can't upload file of this format", undefined, {
          duration: 5 * 1000
        });
      })
  }

  public onUpload(): void {
    // @ts-ignore
    if (this.descriptionFormControl.valid) {
      this.isLoadingResults = true;
      const request = { description: this.descriptionFormControl.get('description')?.value, document: this.uploadedFile, userId: '4da64240-b567-44fc-98c7-5d1f91cb9982' }
      this.signingProcessService.upload(request).subscribe({
        next: data => {
          this.isLoadingResults = false;
          this.snackbar.open("Document sucessfully uploaded", undefined, {
            duration: 5 * 1000
          });
        },
        error: error => {
          this.isLoadingResults = false;
          this.snackbar.open("Unable to upload document", undefined, {
            duration: 5 * 1000
          });
        }
      });
    }
  }
}
