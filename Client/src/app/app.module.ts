import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CustomMaterialModule } from './core/material.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, FormControl, FormGroup } from '@angular/forms';
import { MatTabsModule } from '@angular/material';
import { MatExpansionModule } from '@angular/material/expansion';

import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { RegistrationFormComponent } from './components/registration-form/registration-form.component';
import { TeamComponent } from './components/team/team.component';
import { LeagueComponent } from './components/league/league.component';
import { TeamSearchComponent } from './components/team-search/team-search.component';
import { LeagueSearchComponent } from './components/league-search/league-search.component';
import { HomeComponent } from './components/home/home.component';
import { SettingsComponent } from './components/settings/settings.component';
import { EditTeamsComponent } from './components/edit-teams/edit-teams.component';
import { GameSchedulesComponent } from './components/game-schedules/game-schedules.component';
import { NewsFeedComponent } from './components/news-feed/news-feed.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    LoginFormComponent,
    RegistrationFormComponent,
    TeamComponent,
    LeagueComponent,
    TeamSearchComponent,
    LeagueSearchComponent,
    HomeComponent,
    SettingsComponent,
    EditTeamsComponent,
    GameSchedulesComponent,
    NewsFeedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    MatTabsModule,
    MatExpansionModule,
    MatListModule,
    HttpClientModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
