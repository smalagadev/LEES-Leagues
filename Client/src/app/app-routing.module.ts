import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SettingsComponent } from './components/settings/settings.component';
import { LeagueComponent } from './components/league/league.component';
import { LeagueSearchComponent } from './components/league-search/league-search.component';
import { TeamComponent } from './components/team/team.component';
import { TeamSearchComponent } from './components/team-search/team-search.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'settings', component: SettingsComponent},
  {path: 'league', component: LeagueComponent},
  {path: 'league_search', component: LeagueSearchComponent},
  {path: 'team', component: TeamComponent},
  {path: 'team_search', component: TeamSearchComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
