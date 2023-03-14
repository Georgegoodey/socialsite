import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ProfileList from './ProfileList';
import Nav from './Nav';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header>
          <Nav />
        </header>
        <header className="App-header">
          <ProfileList/>
        </header>
      </div>
    );
  }
}

export default App;