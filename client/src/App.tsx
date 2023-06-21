import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ProfileList from './ProfileList';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header>
        </header>
        <header className="App-header">
          <ProfileList/>
        </header>
      </div>
    );
  }
}

export default App;