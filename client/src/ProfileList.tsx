import React, { Component } from 'react';

type CreateUserResponse = {
  name: string;
  job: string;
  id: string;
  createdAt: string;
};

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

    const response = await fetch('http://localhost:3001/Profiles', {
      method: 'GET',
      headers: {
        Accept: 'application/json',
      },
    });
    const data = await response.json();
    // const send = await fetch('http://localhost:3000/Profiles', {
    //   method: 'POST',
    //   body: JSON.stringify({
    //     name: 'John Smith',
    //     email: 'a@b.com',
    //   }),
    //   headers: {
    //     'Content-Type': 'application/json',
    //     Accept: 'application/json',
    //   },
    // });
    // const result = (await send.json()) as CreateUserResponse;

    // console.log('result is: ', JSON.stringify(send, null, 4));
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