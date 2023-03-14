import React, { Component } from 'react';

interface Profile {
  id: string;
  name: string;
  email: string;
}

interface ProfileListProps {
}

interface ProfileListState {
  profiles: Array<Profile>;
  isLoading: boolean;
}

class ProfileList extends Component<ProfileListProps, ProfileListState> {

  constructor(props: ProfileListProps) {
    super(props);

    this.state = {
      profiles: [],
      isLoading: false
    };
  }

  async componentDidMount() {
    this.setState({isLoading: true});

    const response = await fetch('http://localhost:3000/Profiles');
    const data = await response.json();
    this.setState({profiles: data, isLoading: false});
  }

  render() {
    const {profiles, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
        <h2>All Profiles</h2>
        {profiles.map((profile: Profile) =>
          <div key={profile.id}>
            {profile.name}<br/>
            {profile.email}<br/>
          </div>
        )}
      </div>
    );
  }
}

export default ProfileList;